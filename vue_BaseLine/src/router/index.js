import Vue from 'vue';
import VueRouter from 'vue-router';
import Home from '../views/Home.vue';
import Regist from '../views/Regist.vue';
import Show from '../views/RegistShow.vue';
import vuexTest from '../views/VuexTest.vue';
import Setting from '../views/Setting.vue';

Vue.use(VueRouter);

const routes = [
	{
		path: '/',
		name: 'Home',
		component: Home,
	},
	{
		path: '/regist',
		name: 'Regist',
		component: Regist,
	},
	{
		path: '/show',
		name: 'Show',
		component: Show,
	},
	{
		path: '/vuexTest',
		name: 'vuexTest',
		component: vuexTest,
	},
	// 메뉴 세팅
	{
		path: '/setting',
		name: 'Setting',
		component: Setting,
	},
	{
		path: '/about',
		name: 'About',
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () =>
			import(/* webpackChunkName: "about" */ '../views/About.vue'),
	},
];

const router = new VueRouter({
	routes,
});

export default router;
