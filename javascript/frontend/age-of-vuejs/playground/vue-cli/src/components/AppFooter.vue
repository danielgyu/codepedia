<template>
    <button v-on:click="passEvent">send</button>
</template>

<script>
export default {
    methods: {
        passEvent: function() {
            this.$emit('footerEvent')
        }
    }
}
</script>

<style>
</style>