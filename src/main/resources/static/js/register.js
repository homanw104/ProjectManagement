$(document)
    .ready(function() {
        $('.ui.form')
            .form({
                fields: {
                    uid: {
                        identifier : 'uid',
                        rules:[
                            {
                                type   : 'empty',
                                prompt : '未输入学工号，uid，plz'
                            }
                        ]
                    },
                    name: {
                        identifier  : 'name',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '没写名字，君の名前は？'
                            }
                        ]
                    },
                    password: {
                        identifier  : 'password',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '是不是忘写密码了？'
                            }
                        ]
                    },
                    password_repeat: {
                        identifier  : 'password-repeat',
                        rules: [
                            {
                                type   : 'empty',
                                prompt : '再输入一次密码啦~',
                            }
                        ]
                    },
                }
            })
        ;
    })
;