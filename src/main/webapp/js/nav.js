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
						<li><div class="btn" style="color: gray;font-size: 18px;"><a href="my-wj.html" style="color: gray;text-decoration: none;">参与调查</a></div></li>
						<li class="dropdown">
							<span class="dropdown-toggle btn" data-toggle="dropdown" style="color: gray;font-size: 18px;" >个人中心</span>
							<ul class="dropdown-menu">
								<li><a href="my-wj.html">我的问卷</a></li>
								<li><a>我的信息</a></li>
								<li><a href="logout">切换用户</a></li>
								<li><a href="logout">注销</a></li>
							</ul>
						</li>
						<li><div class="btn" style="color: gray;font-size: 18px;"><a href="edit-wj.html" style="color: gray;text-decoration: none;">创建问卷</a></div></li>
					</ul>
				</div>
			</div>
		</nav>
	`
})
var nav=new Vue({
	el:"#top"
})
