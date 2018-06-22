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
        })
    }
};

jQuery(document).ready(function() {
    FormControls.init()
});

