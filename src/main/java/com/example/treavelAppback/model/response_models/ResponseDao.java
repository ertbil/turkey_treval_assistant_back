package com.example.treavelAppback.model.response_models;

public class ResponseDao<T>{
    private boolean success;
    private T data;
    private String error;

    public ResponseDao(boolean success, T data, String error) {
        this.success = success;
        this.data = data;
        this.error = error;
    }

    public ResponseDao(T data) { // burada t string gelirse hata gelir ama json veri gönderiyoruz bundan değişmesine gerek yok gibi
        //olur da patlarsa sınıfın altındaki gibi yap
        this.success = true;
        error = null;
        this.data = data;
    }

    public ResponseDao(String error) {
        this.success = false;
        this.error = error;
        data = null;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


}

/*public class ResponseDto<T> {
    private boolean success;
    private String error;
    private T data;

    private ResponseDto() {
    }

    public boolean isSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }

    public T getData() {
        return data;
    }

    public static class Builder<T> {
        private boolean success;
        private String error;
        private T data;

        public Builder<T> success() {
            this.success = true;
            return this;
        }

        public Builder<T> error(String error) {
            this.success = false;
            this.error = error;
            return this;
        }

        public Builder<T> data(T data) {
            this.data = data;
            return this;
        }

        public ResponseDto<T> build() {
            ResponseDto<T> responseDto = new ResponseDto<>();
            responseDto.success = success;
            responseDto.error = error;
            responseDto.data = data;
            return responseDto;
        }
    }
}
*/
