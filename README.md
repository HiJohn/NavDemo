# NavDemo
 Jetpack navigation demo

_Remind_
1. navigation的主要三概念，Navigation graph/NavHost/NavController
2. Navigation graph: 就是一个xml，包含参与跳转的所有fragment，以及跳转action，参数等等
3. NavHost :空容器，用来展示目的地Fragment，包含一个默认实现 NavHostFragment，可以自己自定义
4. NavController ：一个控制器api对象，用它来up或者back，navigation到对应的页面
5. 传递数据可以用xml里配置，也可以使用api传入bundle，也可以使用一个父activity生命周期的viewModel
6. 可以在xml配置跳转action，配置跳转的动画
7. 


## TODO 
1. 使用 viewModel 在fragment之间传值，监听数据变动
2. 使用 Safe Args 安全传递数据
3. 使用 深层链接 NavDeepLinkBuilder 
4. 