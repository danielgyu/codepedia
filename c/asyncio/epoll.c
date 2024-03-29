#include <stdio.h>
#include <unistd.h>
#include <sys/epoll.h>
#include <string.h>

#define MAX_EVENTS 5
#define READ_SIZE 10

int close_epoll_fd(int epoll_fd) {
    if (close(epoll_fd)) {
	fprintf(stderr, "failed to close epoll fd\n");
	return 1;
    }

    return 0;
}

int main()
{
    struct epoll_event event;
    struct epoll_event events[MAX_EVENTS];
    size_t bytes_read;
    char read_buffer[READ_SIZE + 1];
    int running = 1;
    int event_count, i;

    int epoll_fd = epoll_create1(0);

    if (epoll_fd == -1) {
	fprintf(stderr, "failed to create epoll fd\n");
	return 1;
    }

    event.events = EPOLLIN;
    event.data.fd = 0;

    if (epoll_ctl(epoll_fd, EPOLL_CTL_ADD, 0, &event)) {
	fprintf(stderr, "failed to add fd to epoll\n");
	close(epoll_fd);
	return 1;
    }

    while (running) {
	printf("\nPolling for input...\n");
	event_count = epoll_wait(epoll_fd, events, MAX_EVENTS, 30000);
	printf("%d ready events\n", event_count);
	
	for (i = 0; i < event_count; i++) {
	    printf("Reading fd '%d' -- ", events[i].data.fd);
	    bytes_read = read(events[i].data.fd, read_buffer, READ_SIZE);
	    printf("%zd bytes read.\n", bytes_read);
	    read_buffer[bytes_read] = '\0';
	    printf("Read '%s'\n", read_buffer);

	    if (!strncmp(read_buffer, "stop\n", 5)) {
		running = 0;
	    }
	}
    }

    close_epoll_fd(epoll_fd);
    return 0;
}
