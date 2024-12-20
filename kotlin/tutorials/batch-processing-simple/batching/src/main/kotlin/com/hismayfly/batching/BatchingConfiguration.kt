package com.hismayfly.batching

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.job.builder.JobBuilder
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.core.step.builder.StepBuilder
import org.springframework.batch.item.database.JdbcBatchItemWriter
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ClassPathResource
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import javax.sql.DataSource

@Configuration
class BatchingConfiguration {

    @Bean
    fun reader(): FlatFileItemReader<Person> {
        return FlatFileItemReaderBuilder<Person>()
            .name("personItemReader")
            .resource(ClassPathResource("information.csv"))
            .delimited()
            .names("firstName", "lastName")
            .targetType(Person::class.java)
            .build()
    }

    @Bean
    fun processor(): PersonItemProcessor {
        return PersonItemProcessor()
    }

    @Bean
    fun writer(dataSource: DataSource): JdbcBatchItemWriter<Person> {
        return JdbcBatchItemWriterBuilder<Person>()
            .sql("INSERT INTO people (first_name, last_name) values (:firstName, :lastName)")
            .dataSource(dataSource)
            .beanMapped()
            .build()
    }

    @Bean
    fun importUserJob(jobRepository: JobRepository, step: Step): Job{
        return JobBuilder("importUserJob", jobRepository)
            .start(step)
            .build()
    }

    @Bean
    fun stepOne(
        jobRepository: JobRepository,
        transactionManager: DataSourceTransactionManager,
        reader: FlatFileItemReader<Person>,
        processor: PersonItemProcessor,
        writer: JdbcBatchItemWriter<Person>): Step {
        return StepBuilder("stepOne", jobRepository)
            .chunk<Person, Person>(3, transactionManager)
            .reader(reader)
            .processor(processor)
            .writer(writer)
            .build()
    }
}