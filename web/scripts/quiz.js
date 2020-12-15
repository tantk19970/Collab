/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

new Vue({
    el: "#quizSection",
    data() {
        return{
            duration: 10000,
            quizQ: [
                {
                    id: 1,
                    name: "Tại sao lại nhiều Action?",
                    desc: "Kẻ thù nguy hại trước mắt của các mạng Đông Dương được xác định trong Chủ trương và nhận thức mới của Đảng giai đoạn 1936 - 1939 là:",
                },
                {
                    id: 2,
                    name: "Struts là cmg?",
                    desc: "Xúc tiến chuẩn bị cho khởi nghĩa vũ trang là nhiệm vụ trung tâm là nội dung được nêu ra tại:",
                },
                {
                    id: 3,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 4,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 5,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 6,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 7,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 8,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 9,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                },
                {
                    id: 10,
                    name: "Stay as Chó?",
                    desc: "Giai cấp nào ra đời gắn với các cuộc khai thác thuộc địa của thực dân Pháp?",
                }
            ]
        }
    },
    filters: {
        changeTimeFormat(duration)
        {
            // Minutes and seconds
            var mins = ~~((duration % 3600) / 60);
            var secs = ~~duration % 60;

            // Output like "1:01" or "4:03:59" or "123:03:59"
            var time = "";

            time += "" + mins + ":" + (secs < 10 ? "0" : "");
            time += "" + secs;

            return time;
        }
    },
    computed: {
        warningBackground: function () {
            return {
                'bg-warning-timer-200': this.duration === 5,
                'bg-warning-timer-300': this.duration === 4,
                'bg-warning-timer-400': this.duration === 3,
                'bg-warning-timer-500': this.duration === 2,
                'bg-warning-timer-600': this.duration <= 1,
            }
        }
    },
    watch: {
        duration: {
            handler(value) {
                if (value > 0) {
                    setTimeout(() => {
                        this.duration--;
                    }, 1000);
                }
                if (value == 0) {
//                    location.reload();
                }
            },
            immediate: true
        }
    }
});
