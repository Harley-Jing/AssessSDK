# SDK接入文档（IOS）
## 1. 导入SDK
  1.1 **将Assesslib.framework和SystemConfiguration.framework导入工程**
![在这里插入图片描述](https://img-blog.csdnimg.cn/20200523181442783.png)
## 2.头文件
  2.1导入头文件
  ````objc
  #import <Assesslib/Assesslib.h>
  ````
 ## 3. API
 3.1**实现协议**

 协议
 ````objc
  <AssesslibDelegate>
````
示例：

````objc
@interface ViewController : UIViewController<AssesslibDelegate>
````

 3.2 **初始化（必接）**

  在启动的时候添加初始化，传入YES表示开启调试模式，可以得到更为详细的日志，传入NO关闭调试模式，关闭日志，日志可以通过搜索关键字AssesslibLog得到

|参数|说明  |值|
|--|--|--|
| model |打开调试模式 |YES|
||关闭调试模式|NO|

函数
````objc
-(void)AssesslibInitWithDebug:(BOOL)model;
````
示例：

````objc
[[Assesslib AssesslibShareInstance]AssesslibInitWithDebug:YES];
````
3.3**指定代理**
代理
````objc
@property (nonatomic, weak) id <AssesslibDelegate> assesslibDelegate;
````
示例：
````objc
[Assesslib AssesslibShareInstance].assesslibDelegate = self;
````

3.4 **登录（必接）**

登录接口需在初始化成功之后调用。若玩家先前已经登录，则自动登录；否则跳转到登录界面。

函数
````objc
-(void)showLoginPanel;
````
示例：
````objc
[[Assesslib AssesslibShareInstance]showLoginPanel];

````
3.5 **退出登录（必接）**

玩家登出游戏时，注销SDK登录状态信息。

函数
````objc
-(void)Logout;
````
示例：

````objc
[[Assesslib AssesslibShareInstance]Logout];
````
3.6 **创建角色（必接）**

在玩家首次创建角色的時候调用此接口，保存玩家角色信息。

函数
````objc
-(void)createRole:(nonnull NSString *)roleId withRoleName:(nullable NSString *)roleName withRoleType:(nullable NSString *)roleType withRoleGender:(int)roleGender withRoleLevel:(int)roleLevel withRoleCreateTime:(nullable NSString *)roleCreateTime;
````
|参数|说明  |
|--|--|
| roleId|角色ID（唯一）  |
| roleName|角色名字  |
| roleType|角色类型  |
| roleGender|角色性别（-1：无性别；0：男； 1：女；）  |
| roleLevel|角色等级  |
| roleCreateTime|创建角色时间  |

示例：
````objc
[[Assesslib AssesslibShareInstance]createRole:@"3759506187" withRoleName:@"璐璐" withRoleType:@"辅助" withRoleGender:1 withRoleLevel:6 withRoleCreateTime:@"202005231644"];
````
3.7 **进入游戏（必接）**

在玩家进入游戏的時候调用此接口，保存玩家角色信息。

函数
````objc
-(void)enterGame:(nonnull NSString *)roleId withRoleName:(nullable NSString *)roleName withRoleType:(nullable NSString *)roleType withRoleGender:(int)roleGender withRoleLevel:(int)roleLevel withVipLevel:(int)vipLevel withRoleCreateTime:(nullable NSString *)roleCreateTime;
````
|参数|说明  |
|--|--|
| roleId|角色ID（唯一）  |
| roleName|角色名字  |
| roleType|角色类型  |
| roleGender|角色性别（-1：无性别；0：男； 1：女；）  |
| roleLevel|角色等级  |
| vipLevel|vip等级  |
| enterGameTime|进入游戏时间  |

示例：
````objc
[[Assesslib AssesslibShareInstance]enterGame:@"3759506187" withRoleName:@"璐璐" withRoleType:@"辅助" withRoleGender:1 withRoleLevel:6 withVipLevel:30 withRoleCreateTime:@"202005231644"];
````    

3.8**实现协议中的回调方法**

  实现回调方法以获得登录回调
函数
````objc
-(void)AssesslibCallBack:(nonnull NSString *) message;
````
示例：

````objc
-(void)AssesslibCallBack:(nonnull NSString *) message
{
    NSLog(@"CallBack message = %@",message);
}
````