import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView
  },
  {
    path: "/reload/:target",
    name: 'reload',
    component: () => import("../components/common/ReloadPage.vue"),
  },
  {
    path: "/login",
    name: "login",
    component: () => import("../views/LoginView.vue"),
  },
  {
    path: "/car",
    name: "car",
    component: () => import("../views/Car/CarView.vue"),
  },
  {
    path: "/car/:id",
    name: "carDetail",
    component: () => import("../views/Car/CarDetail.vue"),
  },
  {
    path: "/car/add",
    name: "carAdd",
    component: () => import("../views/Car/CarAdd.vue"),
  },
  {
    path: "/car/update/:id",
    name: "carUpdate",
    component: () => import("../views/Car/CarUpdate.vue"),
  },
  {
    path: "/user",
    name: "userView",
    component: () => import("../views/User/UserView.vue"),
  },
  {
    path: "/user/:id",
    name: "userDetail",
    component: () => import("../views/User/UserDetail.vue"),
  },
  {
    path: "/user/add",
    name: "userAdd",
    component: () => import("../views/User/UserAdd.vue"),
  },
  {
    path: "/user/update/:id",
    name: "userUpdate",
    component: () => import("../views/User/UserUpdate.vue"),
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
