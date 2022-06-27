import Vue from "vue";
import VueRouter from "vue-router";
Vue.use(VueRouter);

import testBshView from "@/views/testBshView";
import postsView from "@/views/PostsView";
import postsDetailView from "@/views/PostsDetailView";
import loginView from "@/views/LoginView";
import MainView from "@/views/MainView";
import UsersView from "@/views/UsersView";
import PostsAddView from "@/views/PostsAddView";

const routes = [
    {path: "/bsh", name: "bsh", component: testBshView},
    {path: "/posts", name: "posts", component: postsView},
    {path: "/posts/:id", name: "postsDetail", component: postsDetailView, props:true},
    {path: "/login", name: "login", component: loginView},
    {path: "/main", name: "main", component: MainView},
    {path: "/users", name: "users", component: UsersView},
    {path: "/add", name: "add", component: PostsAddView},

]

const router = new VueRouter({
    mode: "history",
    base: process.env.BASE_URL,
    routes,
});

export default router;
