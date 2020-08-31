module.exports = {
  entry: './index.js',
  output: {
    path:path.resolve(__dirname,"build"),
    publicPath:"/assets/",
    filename: 'bundle.js'
  },
  module: {
    rules: [
      { test: /\.js$/, exclude: /node_modules/, loader: "react-hot-loader!babel-loader" },
      { test: /\.css$/, exclude: /node_modules/, loader: "style-loader!css-loader" },
      { test: /\.eot(\?v=\d+\.\d+\.\d+)?$/, loader: "file-loader" },  //���
      { test: /\.(woff|woff2)$/, loader:"url-loader?prefix=font/&limit=5000" }, //���
      { test: /\.ttf(\?v=\d+\.\d+\.\d+)?$/, loader: "url-loader?limit=10000&mimetype=application/octet-stream" }, //���
      { test: /\.svg(\?v=\d+\.\d+\.\d+)?$/, loader: "url-loader?limit=10000&mimetype=image/svg+xml" } //���
    ]
  }
}