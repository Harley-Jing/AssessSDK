# SDK接入文档（Android）
## 1. 导入SDK
  1.1 **将assesslib.jar放置Android工程libs目录下**

  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200520152113387.png)
  
  1.2 **在游戏的主项目build.gradle添加依赖**
  
  ![在这里插入图片描述](https://img-blog.csdnimg.cn/20200520152036103.png)
  
  ## 2. 配置Manifest.xml文件
  2.1 **targetSdkVersion**

  你需要将游戏内的targetSdkVersion版本设为28（SDK目前不适配28以上）

  2.2 **AndroidStudio版本sdk版本号设置**

  游戏的targetSdkVersion,minSdkVersion,compileSdkVersion必须和sdk保持一致，即targetSdkVersion设为28，compileSdkVersion设为28，minSdkVersion设为19。

  2.3 **添加权限**
```java
    <uses-permission android:name="android.permission.INTERNET"/>
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
 ## 3. API
 3.1 **添加Application（必接）**

    在游戏启动之前，需要做一些初始化，因此需要继承sdk的ChannelApplication。

    ==注意在Manifest.xml文件中添加声明==

    示例：
```java
import com.umisdk.assesslib.ChannelAppliaction;

public class GameApplication extends ChannelAppliaction {
    @Override
    public void onCreate() {
        super.onCreate();
        
    }
}
```
3.2 **初始化（必接）**

 在游戏第一个activity的onCreate()方法中调用的初始化方法，该接口执行SDK的一些初始化工作，在调用SDK的其他方法之前必須要先确保SDK初始化成功。

函数
```java
 public void init(Context context)
```
|参数|说明  |
|--|--|
| context |Context上下文  |

示例：
```java
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LoginManager.getInstance().init(this);
    }
```
3.3 **打开调试模式**

打开SDK调试模式，增加调试的Toast以及Log输出
 
 示例：
```java
import com.umisdk.assesslib.ChannelAppliaction;
import com.umisdk.assesslib.SdkSettting;

public class GameApplication extends ChannelAppliaction {
    @Override
    public void onCreate() {
        super.onCreate();
		
		//Debug模式
        SdkSettting.isDebug = true;
    }
}

```

3.4 **登录（必接）**

登录接口需在初始化成功之后调用。若玩家先前已经登录，则自动登录；否则跳转到登录界面。

函数
```java
public void showLoginPanel()
```
示例：

```java
LoginManager.getInstance().showLoginPanel();
```
3.5 **退出登录（必接）**

玩家登出游戏时，注销SDK登录状态信息。

函数
```java
public void logout()
```
示例：

```java
LoginManager.getInstance().logout();
```
3.6 **创建角色（必接）**

在玩家首次创建角色的時候调用此接口，保存玩家角色信息。

函数
```java
 public void createRole(final String roleId, final String roleName, final String roleType,
  				final int roleGender, final int roleLevel, final String roleCreateTime)
```
|参数|说明  |
|--|--|
| roleId|角色ID（唯一）  |
| roleName|角色名字  |
| roleType|角色类型  |
| roleGender|角色性别（-1：无性别；0：男； 1：女；）  |
| roleLevel|角色等级  |
| roleCreateTime|创建角色时间  |

示例：
```java
ReportedData.getInstance(GameActivity.this).createRole("roleId", "roleName", "roleType",
 				1, 1, "roleCreateTime");
```
3.7 **进入游戏（必接）**

在玩家进入游戏的時候调用此接口，保存玩家角色信息。

函数
```java
public void enterGame(final String roleId, final String roleName, final String roleType,
      final int roleGender, final int roleLevel, final int vipLevel, final String enterGameTime)
```
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
```java
ReportedData.getInstance(GameActivity.this).enterGame("roleId", "roleName", "roleType",
                            1, 1, 1, "enterGameTime");
```
