package com.capstone.healthcare.common.exception;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private ErrorCodeService errorCode;
    private String detailMsg;

    public BusinessException() {
    }

    public BusinessException(ErrorCodeService error, String detailMsg) {
        super(detailMsg);
        this.errorCode = error;
        this.detailMsg = detailMsg;
    }

    public BusinessException(ErrorCodeService error) {
        super(error.getMessage());
        this.errorCode = error;
    }

    public BusinessException(ErrorCodeService error, Throwable e) {
        super(error.getMessage(), e);
        this.errorCode = error;
    }

    public ErrorCodeService getErrorCode() {
        return this.errorCode;
    }

    public String getDetailMsg() {
        return this.detailMsg;
    }

    public void setErrorCode(final ErrorCodeService errorCode) {
        this.errorCode = errorCode;
    }

    public void setDetailMsg(final String detailMsg) {
        this.detailMsg = detailMsg;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof BusinessException)) {
            return false;
        } else {
            BusinessException other = (BusinessException)o;
            if (!other.canEqual(this)) {
                return false;
            } else {
                Object this$errorCode = this.getErrorCode();
                Object other$errorCode = other.getErrorCode();
                if (this$errorCode == null) {
                    if (other$errorCode != null) {
                        return false;
                    }
                } else if (!this$errorCode.equals(other$errorCode)) {
                    return false;
                }

                Object this$detailMsg = this.getDetailMsg();
                Object other$detailMsg = other.getDetailMsg();
                if (this$detailMsg == null) {
                    if (other$detailMsg != null) {
                        return false;
                    }
                } else if (!this$detailMsg.equals(other$detailMsg)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof BusinessException;
    }

    public int hashCode() {
        int result = 1;
        Object $errorCode = this.getErrorCode();
        result = result * 59 + ($errorCode == null ? 43 : $errorCode.hashCode());
        Object $detailMsg = this.getDetailMsg();
        result = result * 59 + ($detailMsg == null ? 43 : $detailMsg.hashCode());
        return result;
    }

    public String toString() {
        return "BusinessException(errorCode=" + this.getErrorCode() + ", detailMsg=" + this.getDetailMsg() + ")";
    }
}