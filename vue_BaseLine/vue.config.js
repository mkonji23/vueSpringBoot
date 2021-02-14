module.exports = {
	transpileDependencies: ['vuetify'],
	devServer: {
		//① api 요청이 있을때 어디에서 처리할지를 설정
		proxy: {
			'/api': {
				target: 'http://localhost:8080',
				changeOrigin: true,
			},
		},

		port: process.env.VUE_APP_PORT || 3000,
	},
	outputDir: '../backend/public', // ② 배포 파일의 위치를 지정
};
