
//火锅1店作为抽象类
public abstract class HPRest {
    public abstract HuoGuo createHuoguo(String type);
    //对拥有不同需求的顾客提供不同火锅
    public HuoGuo provideHuoguo(String type) {

        HuoGuo huoguo = createHuoguo(type);

        {
            huoguo.preparation();
            huoguo.plating();
            huoguo.serving();
        }

        return huoguo;
    }
}
