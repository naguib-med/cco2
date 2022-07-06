import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/what",
    name: "What",
    component: () => import("@/views/What.vue"),
  },
  {
    path: "/who",
    name: "Who",
    component: () => import("@/views/Who.vue"),
  },
  {
    path: "/team",
    name: "Team",
    component: () => import("@/views/Team.vue"),
  },
  {
    path: "/ecosystem",
    name: "Ecosystem",
    component: () => import("@/views/Ecosystem.vue"),
  },
  {
    path: "/benchmark",
    name: "Benchmark",
    component: () => import("@/views/Benchmark.vue"),
  },
  {
    path: "/miner",
    name: "Miner",
    component: () => import("@/views/Miner.vue"),
  },
  {
    path: "/account",
    name: "Account",
    component: () => import("@/views/Account.vue"),
  },
  {
    path: "/account-signup",
    name: "Account-Signup",
    component: () => import("@/views/Account-Signup.vue"),
  },
];

const router = new VueRouter({
  routes,
});

export default router;
