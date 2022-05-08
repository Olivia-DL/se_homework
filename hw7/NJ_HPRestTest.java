import static org.junit.jupiter.api.Assertions.*;

class NJ_HPRestTest {

    @org.junit.jupiter.api.Test
    void createHuoguo() {
        HPRest njrest = new NJ_HPRest();
        njrest.provideHuoguo("毛肚");
    }
}