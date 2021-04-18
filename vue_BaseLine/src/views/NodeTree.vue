<template>
	<div>
		<li class="node-tree">
			<span class="label">{{ node.label }}</span>
			<ul v-if="node.children && node.children.length">
				<node :key="child" v-for="child in node.children" :node="child"></node>
			</ul>
		</li>
	</div>
</template>

<script>
export default {
	name: 'node',
	props: ['node'],
};
</script>
