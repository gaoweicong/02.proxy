# 02.proxy
##设计模式之代理模式
`该模式广泛的用于Spring等框架,具体实现方式 有两种,一是java自带的Proxy类,另一个是第三方cglib `
Proxy速度较慢  
cglib底层依赖asm 运行时创建类的子类做代理类,原理上更快一点!
