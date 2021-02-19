<template>
	<div style="margin-left:25px;">
		<v-row>
			<v-col cols="6" sm="3">
				<v-text-field v-model="obj.userId" label="ID" outlined></v-text-field>
			</v-col>
		</v-row>
		<v-row>
			<v-col cols="6" sm="3">
				<v-text-field v-model="obj.password" label="PW" outlined></v-text-field>
			</v-col>
		</v-row>
		<v-row>
			<v-col cols="12" sm="3">
				<v-text-field v-model="obj.name" label="Name" outlined></v-text-field>
			</v-col>
		</v-row>
		<v-row>
			<v-col cols="12" sm="3">
				<v-text-field
					v-model="obj.address"
					label="Address"
					outlined
				></v-text-field>
			</v-col>
		</v-row>

		<v-btn @click="callRegist()">저장</v-btn>
	</div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
export default {
	data() {
		return {
			obj: {
				userId: '',
				password: '',
				name: '',
				address: '',
			},
		};
	},
	computed: {
		...mapState('registStore', ['dataList']),
	},
	methods: {
		...mapActions('registStore', ['getRegistList', 'setRegistList']),
		// 저장로직 콜
		callRegist() {
			console.log(this.obj);
			this.setRegistList(this.obj);
		},
		callStore() {
			this.getRegistList('?');
			console.log('this.dataList', this.dataList);
		},
	},
};
</script>

<style></style>
