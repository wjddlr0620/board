package coffee;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Board_table")
public class Board {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long requestId;
        private String status;
        private Long menuId;
        private Long price;
        private Integer cnt;
        private String orderMethod;
        private String makeStaff;
        private String orderTime;
        private String makeTime;
        private String notifyTime;
        private String cancelTime;
        private String storageStatus;

        public Long getRequestId() {
            return requestId;
        }

        public void setRequestId(Long requestId) {
            this.requestId = requestId;
        }
        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
        public Long getMenuId() {
            return menuId;
        }

        public void setMenuId(Long menuId) {
            this.menuId = menuId;
        }
        public Long getPrice() {
            return price;
        }

        public void setPrice(Long price) {
            this.price = price;
        }
        public Integer getCnt() {
            return cnt;
        }

        public void setCnt(Integer cnt) {
            this.cnt = cnt;
        }
        public String getOrderMethod() {
            return orderMethod;
        }

        public void setOrderMethod(String orderMethod) {
            this.orderMethod = orderMethod;
        }
        public String getMakeStaff() {
            return makeStaff;
        }

        public void setMakeStaff(String makeStaff) {
            this.makeStaff = makeStaff;
        }
        public String getOrderTime() {
            return orderTime;
        }

        public void setOrderTime(String orderTime) {
            this.orderTime = orderTime;
        }
        public String getMakeTime() {
            return makeTime;
        }

        public void setMakeTime(String makeTime) {
            this.makeTime = makeTime;
        }
        public String getNotifyTime() {
            return notifyTime;
        }

        public void setNotifyTime(String notifyTime) {
            this.notifyTime = notifyTime;
        }
        public String getCancelTime() {
            return cancelTime;
        }

        public void setCancelTime(String cancelTime) {
            this.cancelTime = cancelTime;
        }
        public String getStorageStatus() {
            return storageStatus;
        }

        public void setStorageStatus(String storageStatus) {
            this.storageStatus = storageStatus;
        }
}
