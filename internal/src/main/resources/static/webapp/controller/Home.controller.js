sap.ui.define([
    "sap/ui/core/mvc/Controller",
    "../model/formatter",
    "sap/ui/core/Fragment",
    "sap/m/Button",
    "sap/m/Dialog",
    "sap/m/Label",
    "sap/m/MessageToast",
    "sap/m/Text",
    "sap/m/TextArea",
    "sap/m/ButtonType",
    "sap/ui/layout/VerticalLayout",
], function (Controller, formatter, Fragment, Button, Dialog,
             Label, MessageToast, Text, TextArea, ButtonType, VerticalLayout) {
    "use strict";

    return Controller.extend("sap.ui.demo.basicTemplate.controller.Home", {

        formatter: formatter,
        dialog: null,

        onInit: function () {

            var controller = this;

            fetch("metadata/basicInfo.json")
                .then(data => data.json())
                .then(json => controller.metadata = json)

        },

        onHireEmployee: function () {


			var model = new sap.ui.model.json.JSONModel({});

            var dialog = new Dialog({
                title: this.metadata.title,
                type: 'Message',
                content: this.buildContent(),
                beginButton: new Button({
                    type: ButtonType.Emphasized,
                    text: 'Submit',
                    press: function () {
                        MessageToast.show('Submit pressed!');
                        console.log(model.getData());
                        dialog.close();
                    }
                }),
                endButton: new Button({
                    text: 'Cancel',
                    press: function () {
                        dialog.close();
                    }
                }),
                afterClose: function () {
                    dialog.destroy();
                }
            });
			dialog.setModel(model);
            dialog.open();
        },

        buildContent: function () {

            var content = this.metadata.fields.map(field => {
                    var input = new sap.m.Input({
                        id: field.fieldId,
                        type: "Text",
                        value: "{/" + field.fieldId + "}",
                    });
                    return new sap.ui.layout.HorizontalLayout({
                        content: [
                            new Label({text: field.fieldText}),
                            input
                        ]
                    })
                }
            );

            return new VerticalLayout({
                content: content
            });
        }
    });
});