<script setup>

import { ArrowLeftBold } from '@element-plus/icons-vue';

const memberList = markRaw( resolveComponent( "list/memberList" ) );
const sideMenu = markRaw( resolveComponent( "sidebar/side-menu" ) );

const data = reactive({ selectedList: sideMenu });


const UI = {
	
	beforeMenu() {
		
		data.selectedList = markRaw( sideMenu );
	},
	
	changeMenu( key ) {
		
		data.selectedList = markRaw( memberList );
	}
}
</script>

<template>
	<!-- layout-container-demo -->
	<el-container class="main_container">
		<el-aside class="list_container">
		
			<div class="list_container__header m-box-1">
				<span>Member</span>
				<el-button :icon="ArrowLeftBold" @click="UI.beforeMenu"/>
			</div>
			<el-divider border-style="dashed" />
			<component :is="data.selectedList"
			           @click-menu="UI.changeMenu"
			/>
		</el-aside>
		
		<el-container>
			<el-main class="main_container">
				<div>
					<img class="logo" src="@/assets/image/logo/democracy3.png"  alt="logo"/>
				</div>
			</el-main>
		</el-container>
	</el-container>
</template>
