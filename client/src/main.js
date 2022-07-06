import Vue from "vue";
import App from "./App.vue";
import router from "./router";

import Vuex from "vuex";
Vue.use(Vuex);

import "carbon-components/css/carbon-components.css";
import CarbonComponentsVue from "@carbon/vue/src/index";
Vue.use(CarbonComponentsVue);

Vue.config.productionTip = false;

const store = new Vuex.Store({
  state: {
    jwtToken: "",
  },
  mutations: {
    updateToken(state, token) {
      state.jwtToken = token;
      console.log("TOKEN: " + state.jwtToken);
    },
  },
  getters: {
    token: (state) => {
      return state.jwtToken;
    },
  },
});

new Vue({
  router,
  store,
  render: (h) => h(App),
}).$mount("#app");
