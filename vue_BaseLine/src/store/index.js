// 파일 위치: /root/src/store/index.js
import Vue from 'vue';
import Vuex from 'vuex';

Vue.use(Vuex);
/**
 *  modules 폴더안에 있는 모든 모듈 가져오기
 */
import modules from './modules';
export const store = new Vuex.Store({
	modules: modules,
});

export default store;
