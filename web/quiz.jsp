<%-- Document : quiz Created on : Dec 14, 2020, 10:44:36 PM Author : Nike --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
              crossorigin="anonymous">
        <link href="css/quiz.css" rel="stylesheet" />
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/vue@2.6.12/dist/vue.js"></script>
        <title>Quiz Page</title>
    </head>

    <body>
        <nav class="navbar navbar-light shadow-sm" style="background: #4ba89c;height: 5rem">
            <div class="container-fluid d-flex justify-content-center">
                <a class="navbar-brand text-white" href="#">Daga Kotowaru</a>
            </div>
        </nav>
        <nav class="navbar navbar-light shadow-sm mb-2" style="background: #20897b;height: 2rem"></nav>
        <div class="container-fluid mx-auto" id="quizSection">
            <div class="row">
                <div class="col-md-3">
                    <div class="card text-center">
                        <div class="p-3 " style="background: #e4f7f6">
                            <h3 class="card-title">Timer</h3>
                        </div>
                        <h5 class="card-text" :class="warningBackground" id="countdown">
                            {{duration | changeTimeFormat}}
                        </h5>
                        <div class="container d-flex justify-content-center flex-wrap">
                            <div v-for="(item,index) in quizQ">
                                <a type="button" class="btn btn-outline-success jump-to-button" :href="'#q'+item.questionId">{{item.questionId}}</a>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-md-9" id="quizQuestion"> 
                    <div class="row"  v-for="(item,index) in quizQ" v-bind:key="index">
                        <div class="card col-md-2 p-3 d-inline-block mx-1" style="max-height: 7rem;max-width: 10rem; background: #eeeeee">
                            Question <span class="fs-4 fw-bold">{{item.questionId}}</span>
                        </div>
                        <div class="card p-3 rounded-3 col-md-10 mb-4" :id="'q'+item.id" style="background: #d9edf7">
                            <h6 class="card-text" id="countdown">
                                {{item.questionContent}}
                            </h6>
                            <div class="form-check" v-for="(anAnswer,index2) in item.answers" v-bind:key="index2">
                                <input class="form-check-input" type="radio" :name="'quizAnswerNo'+item.id">
                                <label class="form-check-label" for="flexRadioDefault1">
                                    {{anAnswer.answerContent}}
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="d-flex flex-row-reverse mt-2">
                        <input class="btn btn-secondary btn-lg" type="button" value="Submit" />
                    </div>
                </div>
            </div>
        </div>
    </body>
    <script src="scripts/quiz.js"></script>

</html>