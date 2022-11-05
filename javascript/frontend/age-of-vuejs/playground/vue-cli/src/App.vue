<template>
  <div>
    <app-header v-bind:propsdata="str"></app-header>
    <app-footer v-on:footerEvent="logText"></app-footer>
  </div>
</template>

<script>
import AppHeader from './components/AppHeader.vue'
import AppFooter from './components/AppFooter.vue'

export default {
  data: function() {
    return {
      str: 'Header!!!',
    }
  },
  components: {
    'app-header': AppHeader,
    'app-footer': AppFooter,
  },
  methods: {
    logText: function() {
      console.log("received event");
    }
  }
}
</script>

<style>
</style>