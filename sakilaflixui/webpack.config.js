const path = require('path');
const ExtractTextPlugin = require('extract-text-webpack-plugin');
const HtmlWebpackPlugin = require('html-webpack-plugin');

const HtmlWebpackPluginConfig = new HtmlWebpackPlugin({
  template: './dist/index.html',
  filename: 'index.html',
  inject: 'body'
})


const config = {
	entry: './src/index.js',
	output: {
		path: path.resolve(__dirname, 'dist'),
		filename: 'bundle.js'
	},
  devtool: 'source-map',
	module: {
		loaders: [
			{
                test: /\.scss$|\.css$/,
                // exclude material css from being loaded by CSS modules
        // These paths are specific to your system, so change accordingly
        exclude: [
          path.resolve('./node_modules/material-components-web'),
          path.resolve('./node_modules/@material')
        ],
                use: ExtractTextPlugin.extract({
                    fallback: 'style-loader',
                    //resolve-url-loader may be chained before sass-loader if necessary
                    use: [{
                        loader: 'css-loader',
                        options: {
                            minimize: true,
                            modules: false
                        }   
                      },'sass-loader']
                })
            },
            {
        test: /\.css$/,
        // only turn on standard global CSS loader for the material directories
        // These paths are the same as above and specific to your system, so change accordingly
        include: [
          path.resolve('./node_modules/material-components-web'),
          path.resolve('./node_modules/@material')
        ],
        use: ['style-loader', 'css-loader']
      },
            {
                test: /\.(js|jsx)$/,
                exclude: /(node_modules)/,
                loaders: ['react-hot-loader/webpack', 'babel-loader']
            },
            {
                test: /\.(svg|woff|woff2|eot|ttf)$/,
                loader: 'file-loader?name=fonts/[name].[ext]',
            }
		]
	},
	plugins: [
    new ExtractTextPlugin('style.css'),
    HtmlWebpackPluginConfig],
  devServer:{
    proxy:{
      '/movieservice':{
        target: 'http://192.168.1.3:8765/',
        changeOrigin: true
      },
      '/inventory':{
        target: 'http://192.168.1.3:8765/',
        changeOrigin: true
      },
      '/customer':{
        target: 'http://localhost:8080/',
        changeOrigin: true
      }
    }    
  }

};


module.exports = config;