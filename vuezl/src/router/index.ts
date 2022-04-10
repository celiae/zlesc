import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import Home from "../views/Home.vue";

const routes: Array<RouteRecordRaw> = [
  {
    path: "/reload/:target",
    component: () => import("../components/Reload.vue"),
  },
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("../views/Login.vue"),
  },
  {
    path: "/car",
    name: "Car",
    component: () => import("../views/Car/Car.vue"),
  },
  {
    path: "/car/:id",
    name: "CarDetail",
    component: () => import("../views/Car/CarDetail.vue"),
  },
  {
    path: "/car/add",
    component: () => import("../views/Car/CarAdd.vue"),
  },
  {
    path: "/car/update/:id",
    name: "CarUpdate",
    component: () => import("../views/Car/CarUpdate.vue"),
  },
  {
    path: "/user",
    component: () => import("../views/User/User.vue"),
  },
  {
    path: "/user/:id",
    component: () => import("../views/User/UserDetail.vue"),
  },
  {
    path: "/user/add",
    component: () => import("../views/User/UserAdd.vue"),
  },
  {
    path: "/user/update/:id",
    component: () => import("../views/User/UserUpdate.vue"),
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
