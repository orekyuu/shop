const ExtractTextPlugin = require('extract-text-webpack-plugin');
const path = require('path');

module.exports = {
    context: path.join(__dirname, './src'),
    entry: {
        style: "./style/main.scss",
    },
    output: {
        path: path.join(__dirname, './build'),
        filename: '[name].css'
    },
    module: {
        rules: [
            {
                test: /\.scss$/,
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    use: ['css-loader', 'sass-loader']
                })
            }
        ]
    },
    plugins: [
        new ExtractTextPlugin('[name].css')
    ]
};
