<template>
	<div>
		<v-btn main @click="childData(5)">저장</v-btn>
		<div class="tree">
			<ul class="tree-list" v-for="val in treeData" :key="val.label">
				<node-tree :node="val"></node-tree>
			</ul>
		</div>
	</div>
</template>

<script>
import NodeTree from './NodeTree';
export default {
	components: {
		NodeTree,
	},
	data() {
		return {
			treeData: [
				{ label: '1', children: [{ label: '1-1' }, { label: '1-2' }] },
				{ label: '2', children: [{ label: '2-1' }, { label: '2-2' }] },
			],
		};
	},
	created() {
		this.childData();
	},

	methods: {
		childData(length) {
			let array = [];
			for (let i = 0; i < length; i++) {
				array.push({ label: i, children: this.makeChildArray(3) });
			}
			console.log(array);
			return array;
		},

		makeChildArray(length) {
			let array = [];
			for (let i = 0; i < length; i++) {
				array.push({ label: i });
			}
			console.log(array);
			return array;
		},
	},
};
</script>
<style>
.tree-list ul {
	padding-left: 16px;
	margin: 6px 0;
}
</style>
