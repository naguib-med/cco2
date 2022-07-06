<template>
  <div id="app">
    <app-header />
    <div id="main-content">
      <router-view />
    </div>
  </div>
</template>

<script>
import AppHeader from "@/components/AppHeader";

export default {
  name: "App",
  components: {
    AppHeader,
  },
};
</script>

<style lang="scss">
#app {
  font-family: IBM Plex Sans;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

div#main-content {
  margin-left: 16rem;
  margin-top: 3rem;
}

@media (max-width: 65.98rem) {
  div#main-content {
    margin-left: 0rem;
    margin-top: 3rem;
  }
}
</style>
