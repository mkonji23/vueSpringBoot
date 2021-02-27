<template>
	<v-app id="inspire">
		<v-navigation-drawer v-model="drawer" app>
			<v-list dense>
				<v-list-item link @click="goPush('/')">
					<v-list-item-action>
						<v-icon>mdi-home</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title>Home</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
				<v-list-item link @click="goPush('/regist')">
					<v-list-item-action>
						<v-icon>mdi-email</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title>Call Api</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
				<v-list-item link @click="goPush('/show')">
					<v-list-item-action>
						<v-icon>mdi-thumb-up</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title>Show</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
				<v-list-item link @click="goPush('/vuexTest')">
					<v-list-item-action>
						<v-icon>mdi-checkbox-marked-circle</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title>Vuex</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
				<v-list-item link @click="goPush('/setting')">
					<v-list-item-action>
						<v-icon>mdi-bowling</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title>setting</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
				<v-list-item link @click="goPush('/login')">
					<v-list-item-action>
						<v-icon>mdi-bowling</v-icon>
					</v-list-item-action>
					<v-list-item-content>
						<v-list-item-title>Login</v-list-item-title>
					</v-list-item-content>
				</v-list-item>
			</v-list>
		</v-navigation-drawer>

		<v-app-bar app color="indigo" dark>
			<v-app-bar-nav-icon @click.stop="drawer = !drawer"></v-app-bar-nav-icon>
			<v-toolbar-title>Application</v-toolbar-title>
		</v-app-bar>

		<v-main>
			<v-container fluid>
				<router-view></router-view>
			</v-container>
		</v-main>
		<v-footer color="indigo" app>
			<span class="white--text">&copy; {{ new Date().getFullYear() }}</span>
		</v-footer>
	</v-app>
</template>

<script>
export default {
	props: {
		source: String,
	},
	data: () => ({
		drawer: null,
	}),

	methods: {
		goPush(route) {
			this.$router.push(route).catch(() => {});
		},
	},
};
</script>
