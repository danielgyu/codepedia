#include <functional>
#include <memory>

#include "rclcpp/rclcpp.hpp"
#include "std_msgs/msg/string.hpp"

using std::placeholders::_1;


class HelloWorldSubscriber : public rclcpp::Node
{
public:
  HelloWorldSubscriber()
  : Node("helloworld_subscriber")
  {
    auto qos_profile = rclcpp::QoS(rclcpp::KeepLast(10));
    helloworld_subscriber_ = this->create_subscription<std_msgs::msg::String>(
      "helloworld",
      qos_profile,
      std::bind(&HelloWorldSubscriber::subscribe_topic_message, this, _1));
  }

private:
  void subscribe_topic_message(const std_msgs::msg::String::SharedPtr msg) const
  {
    RCLCPP_INFO(this->get_logger(), "Received message: `%s`", msg->data.c_str());
  }

  rclcpp::Subscription<std_msgs::msg::String>::SharedPtr helloworld_subscriber_;

};


int main(int argc, char * argv[])
{
  rclcpp::init(argc, argv);
  auto node = std::make_shared<HelloWorldSubscriber>();
  rclcpp::spin(node);
  rclcpp::shutdown();
  return 0;
}
