Vue.component("top",{
	template:`
		<nav class="navbar navbar-default" style="margin-bottom:10px;background-color:white;border: 0;border-bottom: 1px solid gainsboro;">
			<div class="container" >
				<!--最终显示-->
				<div class="navbar-header" >
						<div class="navbar-brand">
							<a href="index.html" style="text-decoration: none;font-size: 20px;color: black;font-weight: bolder;">问卷网</a>
						</div>
					<div class="navbar-toggle" data-toggle="collapse" data-target=".collapse">
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</div>
				</div>
				<!--折叠部分-->
				<div class="pull-right navbar-collapse collapse" style="height: 200px;">
					<ul class="navbar-nav nav navbar-btn">
						<li>
							<div class="btn" style="color: gray;font-size: 18px;">
								<a v-if="islogin" href="my-wj.html" style="color: gray;text-decoration: none;">参与调查</a>
								<a v-if="!islogin" href="user-login.html" style="color: gray;text-decoration: none;">参与调查</a>
							</div>
						</li>
						<li class="dropdown">
							<span class="dropdown-toggle btn" data-toggle="dropdown" style="color: gray;font-size: 18px;" >个人中心</span>
							<ul class="dropdown-menu">
								<li v-if="islogin"><a href="my-wj.html">我的问卷</a></li>
								<li v-if="!islogin"><a href="user-login.html">我的问卷</a></li>
								<li v-if="islogin"><a>我的信息</a></li>
								<li v-if="!islogin"><a>我的信息</a></li>
								<li v-if="islogin"><a href="logout">注销</a></li>
								<li v-if="!islogin"><a href="logout">登录</a></li>
							</ul>
						</li>
						<li v-if="isadmin"><div class="btn" style="color: gray;font-size: 18px;"><a href="admin-manager.html" style="color: gray;text-decoration: none;">管理后台</a></div></li>
					</ul>
				</div>
			</div>
		</nav>
	`,data(){
		return{
			islogin
		}
		return{
			isadmin
		}
	},beforeCreate(){
		isadmin=false
		$.ajax({
			url:"islogin",
			async:false,
			success:function(data){
				if(data.success){
					islogin=true;
					if(data.data=="0"){
						isadmin=true;
					}if(data.data==null){
						isadmin=false;
					}
				}else{
					islogin=false;
				}
			}
		})
	}
})
var nav=new Vue({
	el:"#top"
})
