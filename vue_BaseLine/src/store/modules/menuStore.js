import http from 'axios';

const menuStore = {
	namespaced: true,
	state: {
		dataList: [],
	},
	getters: {
		GE_POST_LIST: state => state.postList,
	},
	mutations: {
		MU_REGIST_LIST: (state, payload) => {
			state.dataList = payload;
		},
	},
	actions: {
		getRegistList: ({ commit }, payload) => {
			http
				.get('/api/regist/select')
				.then(res => {
					commit('MU_REGIST_LIST', res);
				})
				.catch(err => {
					console.log(err);
				});
		},
	},
};

export default menuStore;
