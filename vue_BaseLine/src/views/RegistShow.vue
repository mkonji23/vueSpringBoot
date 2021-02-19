<template>
	<div>
		<v-card>
			<div>
				<v-card-title>
					<div>
						사용자리스트
					</div>
					<v-spacer></v-spacer>
					<div style="width:350px">
						<v-text-field
							v-model="search"
							append-icon="mdi-magnify"
							label="Search"
							width="100px"
							single-line
							hide-details
						></v-text-field>
					</div>
				</v-card-title>
				<v-card-title>
					<v-spacer></v-spacer>
					<div style="margin-right:10px;">
						<v-btn dark class="mb-2" @click="callSelect()">전체 조회</v-btn>
					</div>
					<v-dialog v-model="dialog" max-width="500px">
						<template v-slot:activator="{ on, attrs }">
							<v-btn color="primary" dark class="mb-2" v-bind="attrs" v-on="on">
								New
							</v-btn>
						</template>
						<!-- 팝업카드창 -->
						<v-card>
							<v-card-title>
								<span class="headline">Registration</span>
							</v-card-title>
							<v-card-text>
								<v-container>
									<v-row>
										<v-col cols="12" sm="6" md="4">
											<v-text-field
												v-model="items.userId"
												label="ID"
											></v-text-field>
										</v-col>
										<v-col cols="12" sm="6" md="4">
											<v-text-field
												v-model="items.password"
												label="PW"
											></v-text-field>
										</v-col>
										<v-col cols="12" sm="6" md="4">
											<v-text-field
												v-model="items.name"
												label="Name"
											></v-text-field>
										</v-col>
										<v-col cols="12" sm="6" md="4">
											<v-text-field
												v-model="items.address"
												label="address"
											></v-text-field>
										</v-col>
										<v-col cols="12" sm="6" md="4">
											<v-text-field
												v-model="items.createdTime"
												label="Created Time"
											></v-text-field>
										</v-col>
									</v-row>
								</v-container>
							</v-card-text>
							<v-card-actions>
								<v-spacer></v-spacer>
								<v-btn color="blue darken-1" text @click="close">
									Cancel
								</v-btn>
								<v-btn color="blue darken-1" text @click="save">
									Save
								</v-btn>
							</v-card-actions>
						</v-card>
					</v-dialog>
				</v-card-title>
			</div>
			{{ items }}
			<v-data-table :headers="headers" :items="items" :search="search">
				<template v-slot:item.actions="{ item }">
					<v-icon small class="mr-2" @click="editItem(item)">
						mdi-pencil
					</v-icon>
					<v-icon small @click="deleteItem(item)">
						mdi-delete
					</v-icon>
				</template>
			</v-data-table>
		</v-card>
		<v-snackbar v-model="snackbar" :right="true" :timeout="2000">
			조회가 완료되었습니다.
			<template v-slot:action="{ attrs }">
				<v-icon large v-bind="attrs" @click="snackbar = false">
					mdi-alpha-x-circle-outline
				</v-icon>
			</template>
		</v-snackbar>
		<v-snackbar
			v-model="snackbarError"
			:right="true"
			:timeout="20010"
			color="red"
		>
			에러가 발생했습니다.
			<template v-slot:action="{ attrs }">
				<v-icon large v-bind="attrs" @click="snackbarError = false">
					mdi-alpha-x-circle-outline
				</v-icon>
			</template>
		</v-snackbar>
	</div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
const API_URL = 'http://localhost:8080/api';

export default {
	data() {
		return {
			dialog: false,
			snackbarError: false,
			snackbar: false,
			search: '',
			headers: [
				{
					text: 'userId',
					align: 'start',
					sortable: false,
					value: 'userId',
				},
				{ text: 'password', value: 'password' },
				{ text: 'name', value: 'name' },
				{ text: 'address', value: 'address' },
				{ text: 'Created Time', value: 'createdTime' },
				{ text: 'updated Time', value: 'updateTime' },
				{ text: 'Actions', value: 'actions', sortable: false },
			],
			items: [],
		};
	},
	created() {
		this.callSelect();
		console.log(process.env);
	},
	computed: {
		...mapState('registStore', ['dataList']),
	},
	methods: {
		...mapActions('registStore', ['getRegistList']),
		callStore() {
			// this.getRegistList('?');
			console.log('this.dataList', this.dataList);
		},
		// 조회
		callSelect() {
			this.$http
				.get('/api/user/getList')
				// .get('/user/userList/test')
				.then(res => {
					console.log(res);
					this.items = res.data;
					this.callStore();
					this.snackbar = 'true';
				})
				.catch(err => {
					console.log(err);
					this.snackbarError = 'true';
				});
		},

		close() {
			this.dialog = false;
		},

		save() {},
	},
};
</script>

<style></style>
