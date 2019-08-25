const MiniCssExtractPlugin = require('mini-css-extract-plugin');
const FixStyleOnlyEntriesPlugin = require("webpack-fix-style-only-entries");
const path = require('path');

module.exports = {
    mode: "production",
    context: path.join(__dirname, './src'),
    entry: {
        "style/application": "./style/application.scss",
        "js/application": "./js/application.js"
    },
    output: {
        path: path.join(__dirname, './build'),
        filename: '[name].js'
    },
    module: {
        rules: [
            {
                test: /\.js$/,
                exclude: /node_modules/,
                use: [
                    {
                        loader: "babel-loader",
                        options: {
                            presets: [["@babel/preset-env", {modules: false}]]
                        }
                    }
                ]
            },
            {
                test: /\.(sc|c)ss$/,
                use: [
                    {
                        loader: MiniCssExtractPlugin.loader,
                    },
                    'css-loader',
                    'sass-loader',
                ],
            },
        ]
    },
    plugins: [
        new FixStyleOnlyEntriesPlugin(),
        new MiniCssExtractPlugin({
            filename: '[name].css'
        }),
    ]
};
