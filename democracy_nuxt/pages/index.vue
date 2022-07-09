<template>
	<q-layout view="lHh lpR lFf">
		
		<q-drawer show-if-above v-model="leftDrawerOpen" side="left" behavior="desktop" elevated>
			<span>대화방영역</span>
			<!-- drawer content -->
		</q-drawer>
		
		<q-page-container>
			<span>컴포넌트 영역</span>
			<span>기본 영역</span>
			<router-view />
		</q-page-container>
	
	</q-layout>
</template>

<script lang="ts">
import { ref, defineComponent } from "vue";
import HelloWorld from "~/components/HelloWorld.vue";
export default defineComponent({
  components: {
    HelloWorld
  },
  setup() {
    return {
      leftDrawerOpen: ref(false),
    };
  },
});
</script>