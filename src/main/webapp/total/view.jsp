<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="container-fluid">
      <div class="row">
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h3 class="page-header">日记统计</h3>
          <span>敬请期待！(后续版本增加此功能)</span>
          <div id="id-echart-bar" style="height:500px;width:650px;"></div><hr>
         
        </div>
      </div>
</div>
 <script type="text/javascript">
      // 路径配置
      require.config({
        paths: {
          echarts: 'http://echarts.baidu.com/build/dist'
        }
      });
      // 使用
     
     function require(
              [
                'echarts',
                'echarts/chart/bar',  // 使用柱状图需加载bar模块，此处可按需加载
              ],
              function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var barChart = ec.init(document.getElementById('id-echart-bar'));
                var lineChart = ec.init(document.getElementById('id-echart-line'));
                var pieChart = ec.init(document.getElementById('id-echart-pie'));
                var barOption = {
                  title: {  //定义图表标题
                    text: 'ECharts 柱状图表示例'
                  },
                  tooltip: {
                    show: true    //是否显示提示信息
                  },
                  legend: { //定义图表副标题
                    data:['日记按类别统计个数(个)']
                  },
                  xAxis : [ //定义图表X方向坐标
                    {
                      data : ["日常","美食","旅游","测试","私人","休闲"]
                    }
                  ],
                  yAxis : [//定义图表Y方向坐标
                    {
                      type : 'value',
                      axisLabel: {
                        formatter: '{value} %'
                      }
                    }
                  ],
                  series : [
                    {
                      "name":"总量",
                      "type":"bar",
                      "data":[5, 7, 9, 6, 8, 6]
                    }
                  ]
                };
                // 为echarts对象加载数据
                barChart.setOption(barOption);
              }
      );

</script>