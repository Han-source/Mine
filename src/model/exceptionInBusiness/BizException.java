package model.exceptionInBusiness;

public class BizException extends Exception {
    // 내 통장. 잔고 500. 인출 5000000 ...... =>BizException("잔고가 부족하여 인출할 수 없습니다.")
   
   private String msd;

   public BizException(String msd) {
      super();
      this.msd = msd;
   }
   
   public void print() {
      msd = "앙 기모링";
   }
}