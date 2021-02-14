<template>
	<div>
		props test
		<v-text-field v-model="props1"></v-text-field>
		<v-btn :label="버튼이요" @click="goParent">{{ selected }}</v-btn>
	</div>
</template>

<script>
export default {
	name: 'propsTest',
	props: ['props1'],
	data: () => ({
		selected: {},
	}),
	methods: {
		goParent() {
			this.selected = '가라고~~~~~';
		},
	},
};
</script>
