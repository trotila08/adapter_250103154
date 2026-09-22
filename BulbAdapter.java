public class BulbAdapter implements SmartDevice{
    LegacyBulb bulb;
    public BulbAdapter(LegacyBulb bulb, LegacyBulb bulb1) {
        if(bulb==null){
            throw new NullPointerException("legacyBulb is null");
        }
        this.bulb=bulb;
    }
    @Override
    public void turnOn(){
        bulb.setBrightness(255);
    }
    @Override
    public void turnOff(){
        bulb.setBrightness(0);
    }
    @Override
    public boolean isOn(){
        if(!bulb.hasPower()){
            return false;
        }
        else if(bulb.readBrightness() > 0){
            return true;
        }
        else{
            return true;
        }
    }
    @Override
    public int getPowerPercent(){
        if(!bulb.hasPower()){
            return 0;
        }
        int rawBrightness = bulb.readBrightness();
        if(rawBrightness==0){
            return 0;
        }
        int rawPercent=(rawBrightness*100)/rawBrightness;
        int Calibrated=rawPercent+4;
        return Math.min(100,Calibrated);
    }

}
