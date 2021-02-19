<template>
	<v-app>
		<Base />
		<!-- <Login /> -->
	</v-app>
</template>

<script>
import Base from './components/BaseLine';
import Login from '@/views/Login';

export default {
	name: 'App',

	components: {
		Base,
		Login,
	},

	data: () => ({
		//
	}),
};
</script>
