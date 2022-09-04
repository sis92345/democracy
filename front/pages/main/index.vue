<script setup>

import { ArrowLeftBold } from '@element-plus/icons-vue';
import { ref } from "vue";
import {authInfo} from "../../store/auth";
const $router = useRouter();
const  auth = authInfo();

const memberList = markRaw( resolveComponent( "list/memberList" ) );
const sideMenu = markRaw( resolveComponent( "sidebar/side-menu" ) );

const data = reactive({ selectedList: sideMenu });



if (auth.user != null) {
  auth.check(() => {
      $router.replace("/main");
  });
} else {
  auth.isLogin = false;
}

if(auth.isLogin == false){
	$router.push("/login/login_main")
}


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
