package VO.UserVO;

/**
 * Created by xiezhenyu on 2017/6/6.
 * 该VO对应于用户中心界面个人账户界面的总（Total）VO
 */
public class AccountPageTotalVO {
    //账户金额等信息
    private AccountVO accountVO;
    //持仓记录
    private OwnedStocksVO ownedStocksVO;
    //成交记录
    private DealRecordsVO dealRecordsVO;


    public AccountPageTotalVO() {

    }

    public AccountVO getAccountVO() {
        return accountVO;
    }

    public void setAccountVO(AccountVO accountVO) {
        this.accountVO = accountVO;
    }

    public OwnedStocksVO getOwnedStocksVO() {
        return ownedStocksVO;
    }

    public void setOwnedStocksVO(OwnedStocksVO ownedStocksVO) {
        this.ownedStocksVO = ownedStocksVO;
    }

    public DealRecordsVO getDealRecordsVO() {
        return dealRecordsVO;
    }

    public void setDealRecordsVO(DealRecordsVO dealRecordsVO) {
        this.dealRecordsVO = dealRecordsVO;
    }
}
