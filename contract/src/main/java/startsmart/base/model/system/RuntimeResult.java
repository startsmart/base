package startsmart.base.model.system;

/**
 * Created by sanjeev on 07/08/17.
 */
public class RuntimeResult {
    private int exitStatus;
    private String outPut;
    private String error;

    public RuntimeResult(int exitStatusParam) {
        this.exitStatus = exitStatusParam;
    }

    public int getExitStatus() {
        return this.exitStatus;
    }
    public void setExitStatus(int exitStatus) {
        this.exitStatus = exitStatus;
    }
    public String getOutPut() {
        return this.outPut;
    }
    public void setOutPut(String outPut) {
        this.outPut = outPut;
    }
    public String getError() {
        return this.error;
    }
    public void setError(String error) {
        this.error = error;
    }


}
