<script lang="ts">
import { ref } from 'vue'
import Login from "~/components/auth/login.vue";

export default {
	components: {Login},
	setup () {
		return {
			text: ref('')
		}
	}
}
</script>
<template>
	<div>
		<login />
	</div>
</template>