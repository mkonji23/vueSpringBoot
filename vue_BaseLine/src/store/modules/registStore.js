import http from 'axios';
const registStore = {
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
					commit('MU_REGIST_LIST', res.data);
				})
				.catch(err => {
					console.log(err);
				});
		},
		setRegistList: ({ commit }, payload) => {
			http
				.post('/api/regist', payload)
				.then(res => {
					console.log(res);
				})
				.catch(err => {
					console.log(err);
				});
		},
	},
};

export default registStore;
