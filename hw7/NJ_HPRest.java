//南京火锅店
public class NJ_HPRest extends HPRest{
    @Override
    public HuoGuo createHuoguo(String type) {

        HuoGuo huoguo = null;

        if("肥牛".equals(type)){
            huoguo = new BeefHP();
        }
        else if("毛肚".equals(type)){
            huoguo = new MaoduHP();
        }
        return huoguo;
    }
}