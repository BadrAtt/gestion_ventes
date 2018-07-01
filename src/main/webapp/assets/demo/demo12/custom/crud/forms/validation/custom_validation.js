var FormControls = {
    init: function() {
        $("#articleForm").validate({
            rules: {
                product_name: {
                    required: !0
                },
                product_price: {
                    required: !0,
                    digits: !0
                },
                product_description: {
                    required: !0,
                    minlength:10
                }
            },
            invalidHandler: function(e, r) {
                var i = $("#m_form_1_msg");
                i.removeClass("m--hide").show(), mApp.scrollTo(i, -200)
                return false;
            },
            submitHandler: function(e) {
            	return true;
            }
        }),
        
        $("#loginForm").validate({
            rules: {
                user_email: {
                    required: !0,
                    email: !0
                },
                user_password: {
                    required: !0
                }
            },
            invalidHandler: function(e, r) {
                var i = $("#m_form_1_msg");
                i.removeClass("m--hide").show(), mApp.scrollTo(i, -200)
                return false;
            },
            submitHandler: function(e) {
            	return true;
            }
        }),
        
        $("#clientForm").validate({
            rules: {
            	client_name: {
                    required: !0
                },
                client_prenom: {
                    required: !0
                },
                client_tel: {
                	required: !0,
                    digits: !0
                },
                client_adresse : {
                	required: !0
                }
            },
            invalidHandler: function(e, r) {
                var i = $("#m_form_1_msg");
                i.removeClass("m--hide").show(), mApp.scrollTo(i, -200)
                return false;
            },
            submitHandler: function(e) {
            	return true;
            }
        }),

        $("#userForm").validate({
            rules: {
            	nom_user: {
                    required: !0
                },
                prenom_user: {
                    required: !0
                },
                email_user: {
                	required: !0,
                    email: !0
                },
                password_user : {
                	required: !0
                }
            },
            invalidHandler: function(e, r) {
                var i = $("#m_form_1_msg");
                i.removeClass("m--hide").show(), mApp.scrollTo(i, -200)
                return false;
            },
            submitHandler: function(e) {
            	return true;
            }
        }),
        $("#modalForm").validate({
            rules: {
            	edit_user_name: {
                    required: !0
                },
                edit_user_prenom: {
                    required: !0
                },
                edit_user_email: {
                	required: !0,
                    email: !0
                },
                edit_user_passowrd : {
                	required: !0
                }
            },
            invalidHandler: function(e, r) {
                var i = $("#m_form_1_msg");
                i.removeClass("m--hide").show(), mApp.scrollTo(i, -200)
                return false;
            },
            submitHandler: function(e) {
            	return true;
            }
        }),
        $("#commandeForm").validate({
            rules: {
            	commande_client: {
                    required: !0
                },
                commande_article: {
                    required: !0
                },
                commande_qte : {
                	required: !0,
                	digits: !0
                }
            },
            invalidHandler: function(e, r) {
                var i = $("#m_form_1_msg");
                i.removeClass("m--hide").show(), mApp.scrollTo(i, -200)
                return false;
            },
            submitHandler: function(e) {
            	return true;
            }
        })
    }
};

jQuery(document).ready(function() {
    FormControls.init()
});

